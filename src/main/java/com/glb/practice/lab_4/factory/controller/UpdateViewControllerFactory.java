package com.glb.practice.lab_4.factory.controller;
import com.glb.practice.lab_4.controller.UpdateViewController;
import com.glb.practice.lab_4.controller.Controller;
public class UpdateViewControllerFactory implements ControllerFactory{
    private static UpdateViewControllerFactory updateViewControllerFactory;
    private UpdateViewControllerFactory(){

    }
    @Override 
    public Controller create(){
        return UpdateViewController.getInstance();
    }
    public static UpdateViewControllerFactory getInstance(){
        if(updateViewControllerFactory==null){
            updateViewControllerFactory=new UpdateViewControllerFactory();
        }
        return updateViewControllerFactory;
    }  
}
