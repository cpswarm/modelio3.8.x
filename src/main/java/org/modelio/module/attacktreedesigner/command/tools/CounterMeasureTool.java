package org.modelio.module.attacktreedesigner.command.tools;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.modelio.api.modelio.diagram.IDiagramGraphic;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramLink.LinkRouterKind;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.api.modelio.diagram.ILinkPath;
import org.modelio.api.modelio.diagram.tools.DefaultAttachedBoxTool;
import org.modelio.api.modelio.model.IModelingSession;
import org.modelio.api.modelio.model.ITransaction;
import org.modelio.api.modelio.model.IUmlModel;
import org.modelio.metamodel.uml.infrastructure.Note;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.module.attacktreedesigner.api.AttackTreeNoteTypes;
import org.modelio.module.attacktreedesigner.api.AttackTreeStereotypes;
import org.modelio.module.attacktreedesigner.api.AttackTreeTagTypes;
import org.modelio.module.attacktreedesigner.api.IAttackTreeDesignerPeerModule;
import org.modelio.module.attacktreedesigner.i18n.Messages;
import org.modelio.module.attacktreedesigner.impl.AttackTreeDesignerModule;
import org.modelio.module.attacktreedesigner.utils.elementmanager.representation.DiagramElementBounds;
import org.modelio.module.attacktreedesigner.utils.elementmanager.representation.ElementRepresentationManager;
import org.modelio.module.attacktreedesigner.utils.elementmanager.tags.TagsManager;
import org.modelio.vcore.smkernel.mapi.MObject;

@objid ("44e9eff9-fdf9-424a-8b26-2eee8557bb47")
public class CounterMeasureTool extends DefaultAttachedBoxTool {
    @objid ("bbeee311-cb98-4a26-a18c-9ada8cd12713")
    @Override
    public boolean acceptElement(IDiagramHandle diagramHandle, IDiagramGraphic targetNode) {
        MObject targetElement = targetNode.getElement();
        return (targetElement instanceof Class 
                && ((Class) targetElement).isStereotyped(IAttackTreeDesignerPeerModule.MODULE_NAME, AttackTreeStereotypes.ATTACK)
                && targetElement.getStatus().isModifiable ()
                );
    }

    @objid ("c2df77ce-c32a-4e4c-8db8-0e4d3d849ae8")
    @Override
    public void actionPerformed(IDiagramHandle diagramHandle, IDiagramGraphic originNode, LinkRouterKind routerType, ILinkPath path, Point point) {
        createCounterMeasure(diagramHandle, originNode, point);
    }

    @objid ("b8da66a5-09f8-40f9-8a6f-5e654955d597")
    @Override
    public void actionPerformedInDiagram(final IDiagramHandle diagramHandle, final Rectangle rect) {
    }

    @objid ("af528edd-dcb1-4532-9733-4b1d10d68973")
    public static Note createCounterMeasure(IDiagramHandle diagramHandle, IDiagramGraphic originNode, Point point) {
        Note counterMeasure = null;
        
        IModelingSession session = AttackTreeDesignerModule.getInstance().getModuleContext().getModelingSession();
        IUmlModel model = session.getModel();                
        try( ITransaction transaction = session.createTransaction (Messages.getString("Info.Session.Create", "Counter Measure"))){
            Class counteredAttack = (Class) originNode.getElement();
            
            counterMeasure = model.createNote(IAttackTreeDesignerPeerModule.MODULE_NAME,AttackTreeNoteTypes.COUNTER_MEASURE, counteredAttack, AttackTreeNoteTypes.COUNTER_MEASURE);   
        
            List<IDiagramGraphic> nodeGraphics = diagramHandle.unmask(counterMeasure, point.x, point.y );
            
            // update note bounds
            if(! nodeGraphics.isEmpty()) {
                IDiagramNode diagramNode = (IDiagramNode) nodeGraphics.get(0);
                Rectangle nodeBounds = diagramNode.getBounds();
                nodeBounds.setHeight(DiagramElementBounds.COUNTER_MEASURE.getHeight());
                diagramNode.setBounds(nodeBounds);
            }
            
            // update countered Attack color
            ElementRepresentationManager.setClassColor(counteredAttack, diagramHandle, ElementRepresentationManager.COUNTERED_ATTACK_COLOR);
        
            
            // update countered Attack "Countered attack" tag
            TagsManager.setElementTagValue(counteredAttack, AttackTreeStereotypes.ATTACK, AttackTreeTagTypes.COUNTERED_ATTACK, "true");
            
            diagramHandle.save();
            diagramHandle.close();
            transaction.commit();
        }
        return counterMeasure;
    }

}
