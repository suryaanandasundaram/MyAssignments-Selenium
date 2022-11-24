package com.leaftaps.ui.pages;


import java.util.Properties;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class ViewContactPage extends ProjectSpecificMethods {

	public ViewContactPage(RemoteWebDriver receiveddriver, Properties recprop)
	{
		this.driver=receiveddriver;
		this.prop=recprop;
		PageFactory.initElements(receiveddriver,this);
	}
	
	
	
	
}
