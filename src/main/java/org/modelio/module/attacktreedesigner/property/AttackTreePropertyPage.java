/**
 * Java Class : SysML.java
 *
 * Description :
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing,
 *    software distributed under the License is distributed on an
 *    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *    KIND, either express or implied.  See the License for the
 *    specific language governing permissions and limitations
 *    under the License.
 *
 * @category   Modelio Impl
 * @package    com.modeliosoft.modelio.sysml.properties
 * @author     Modelio
 * @license    http://www.apache.org/licenses/LICENSE-2.0
 * @version    2.0.08
 **/
package org.modelio.module.attacktreedesigner.property;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.module.IModule;
import org.modelio.api.module.propertiesPage.AbstractModulePropertyPage;
import org.modelio.api.module.propertiesPage.IModulePropertyTable;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * This class extends
 */
@objid ("23bf4eaa-6db6-4138-8664-6b16f27ded1e")
public class AttackTreePropertyPage extends AbstractModulePropertyPage {
    /**
     * Constructor
     * @author ebrosse
     * @param module : the associated IModule
     * @param name : the name of the property page
     * @param label : the label of the property page
     * @param bitmap : the bitmap of the property page
     */
    @objid ("801a3c4e-e87e-4923-82de-facf9fce16e6")
    public AttackTreePropertyPage(IModule module, String name, String label, String bitmap) {
        super (module, name, label, bitmap);
    }

    /**
     * This method is called when the current selection changes and that the property box contents requires an update.
     * The ?selectedElements? parameter contains the list of the newly selected elements. The ?table? parameter is the
     * table that must be filled with the updated contents of the property box before returning.
     */
    @objid ("d0ab204e-02c5-4689-aa0d-b68be90eaa15")
    @Override
    public void update(List<MObject> selectedElements, IModulePropertyTable table) {
        if ((selectedElements != null) && (selectedElements.size() > 0)
                && (selectedElements.get(0) != null)
                && (selectedElements.get(0) instanceof ModelElement)){
        
            ModelElement element = ((ModelElement) selectedElements.get(0));
            
            AttackTreePropertyManager sysMLPage = new AttackTreePropertyManager();
            sysMLPage.update(element, table);
        
        }
    }

    /**
     * This method is called when a value has been edited in the property box in the row ?row?. The ?selectedElements?
     * parameter contains the list of the currently selected elements. The ?row? parameter is the row number of the
     * modified value. The ?value? parameter is the new value the user has set to the given row.
     */
    @objid ("5cf28d81-b746-4c5c-acd9-c075bb6c4468")
    @Override
    public void changeProperty(List<MObject> selectedElements, int row, String value) {
        if ((selectedElements != null) && (selectedElements.size() > 0) && (selectedElements.get(0) instanceof ModelElement)){
        
            ModelElement element = ((ModelElement) selectedElements.get (0));
        
            AttackTreePropertyManager propPage = new AttackTreePropertyManager();
            propPage.changeProperty(element, row, value);
            
        }
    }

}
