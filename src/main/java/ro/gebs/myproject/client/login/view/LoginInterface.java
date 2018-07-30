package ro.gebs.myproject.client.login.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import ro.gebs.myproject.client.page1.HistoryEventHandler;
import ro.gebs.myproject.client.inregistrare.view.InregistrareInterface;
import ro.gebs.myproject.client.start.MyProject;
//import ro.gebs.myproject.gui.InregistrareInterface.InregistrareInterface;

public class LoginInterface extends Composite implements HistoryEventHandler {

    private static LoginInterfaceUiBinder uiBinder = GWT.create(LoginInterfaceUiBinder.class);
    private LoginInterface log;

    @Override
    public void handleHistory(String pageId) {

    }


    @UiTemplate("LoginInterface.ui.xml")
    interface LoginInterfaceUiBinder extends UiBinder<Widget,LoginInterface> {

    }

    @UiField(provided = true)
    final LoginInterfaceResources res;



    @UiField
    TextBox loginBox;

    @UiField
    TextBox passwordBox;

    @UiField
    Label completionLabel1;

    @UiField
    Label completionLabel2;

    @UiField
    Button buttonRegister;


    public LoginInterface(){

        this.res=GWT.create(LoginInterfaceResources.class);
        res.style().ensureInjected();

        initWidget(uiBinder.createAndBindUi(this));
        History.newItem("/login",false);
    }

    private Boolean tooShort = false;


    @UiHandler("buttonSubmit")
    void doClickSubmit(ClickEvent event) {
        if (!tooShort) {


            History.newItem("/register",true);

        } else {
            Window.alert("Parola incorecta domnuleeeeeeee!");
        }
        History.newItem("/page1");
    }

    @UiHandler("buttonRegister")
    void doClickRegister(ClickEvent event) {
        RootPanel.get().clear();
        InregistrareInterface inreg = new InregistrareInterface();
        inreg.setLogare(log);
        RootPanel.get().add(inreg);

    }

    @UiHandler("loginBox")
    void handleLoginChange(ValueChangeEvent<String> event) {
        if (event.getValue().length() < 6) {
            completionLabel1.setText("login too short (Size must be > 6)");
            tooShort = true;
        } else {
            tooShort = false;
            completionLabel1.setText("");
        }
    }

    @UiHandler("passwordBox")
    void handlePasswordChange(ValueChangeEvent<String> event) {
        if (event.getValue().length() < 6) {
            tooShort = true;
            completionLabel2.setText("Password too short (Size must be > 6)");
        } else {
            tooShort = false;
            completionLabel2.setText("");
        }
    }



    public void setLogare(LoginInterface logare) {
        this.log = logare;
    }








}
