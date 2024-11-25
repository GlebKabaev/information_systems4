package com.glb.practice.lab_4.factory.view;
import com.glb.practice.lab_4.view.View;
import com.glb.practice.lab_4.view.UpdateAddView;
public class UpdateAddViewFactory implements ViewFactory {
    private static UpdateAddViewFactory updateAddViewFactory;
    private UpdateAddViewFactory(){

    } 
    @Override  
    public View create(){
        return UpdateAddView.getInstance();
    }
    public static UpdateAddViewFactory getInstance(){
        if(updateAddViewFactory==null){
            updateAddViewFactory=new UpdateAddViewFactory();
        }
        return updateAddViewFactory;
    }
}
