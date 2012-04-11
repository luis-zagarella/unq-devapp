package org.assembly.nornas.web.utils.controls;

import org.apache.click.Context;
import org.apache.click.control.Form;

public interface ObjectBinder {
    
    public Object getObject(Context context, Form form);

}
