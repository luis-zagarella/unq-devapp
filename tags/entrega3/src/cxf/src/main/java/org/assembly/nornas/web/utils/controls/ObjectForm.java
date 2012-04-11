package org.assembly.nornas.web.utils.controls;

import org.apache.click.control.Form;

public class ObjectForm extends Form {

    private static final long serialVersionUID = -4886454450065802010L;

    protected static final String BOUND_OBJECT_KEY = ":bound.object";

    protected ObjectBinder objectBinder;
    
    protected Object boundObject;
    
    // ----------------------------------------------------------- Constructors
    
    public ObjectForm(String name, ObjectBinder objectBinder) {
        super(name);
        this.objectBinder = objectBinder;
    }
    
    
    public ObjectForm(String name) {
        super(name);
    }

    public ObjectForm() {
        super();
    }

    // --------------------------------------------------------- Public Methods

    public void onInit() {
        bindObject();
        if (getBoundObject() != null && !isFormSubmission()) {
            copyFrom(getBoundObject());   
        }
    }
    
    public Object getBoundObject() {
        if (boundObject != null) {
            return boundObject;
        }

        String key = getContext().getResourcePath() + BOUND_OBJECT_KEY;
        boundObject = getContext().getSessionAttribute(key);
        
        return boundObject;
    }
    
    public void setBoundObject(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Null object parameter");
        }
        boundObject = object;
    }
    
    public void removeBoundObject() {
        boundObject = null;
        String key = getContext().getResourcePath() + BOUND_OBJECT_KEY;
        getContext().removeSessionAttribute(key);
    }
    
    public void setObjectBinder(ObjectBinder objectBinder) {
        this.objectBinder = objectBinder;
    }
   
    public boolean onProcess() {
        if (getBoundObject() != null && !isFormSubmission()) {
            copyFrom(getBoundObject());
        }
        boolean continueProcessing = super.onProcess();
        onAfterProcess();
        return continueProcessing;
    }
    
    // ------------------------------------------------------ Protected Methods
    
    protected void bindObject() {
        String key = getContext().getResourcePath() + BOUND_OBJECT_KEY;
        if (!getContext().hasSessionAttribute(key)) {
           if (boundObject != null) {
               getContext().setSessionAttribute(key, boundObject);
               
           } else if (objectBinder != null) {
               boundObject = objectBinder.getObject(getContext(), this);
               getContext().setSessionAttribute(key, boundObject);
           }
        }
    }

    protected void onAfterProcess() {
        if (getBoundObject() != null) {
            copyTo(getBoundObject());
        }
    }
    

}
