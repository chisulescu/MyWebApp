package ro.gebs.myproject.client.main.view;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface MainGuiResources extends ClientBundle {

    public interface MyCss extends CssResource{

        String blackText();

        String redText();
    }

    @Source("MainGUI.css")
    MyCss style();
}
