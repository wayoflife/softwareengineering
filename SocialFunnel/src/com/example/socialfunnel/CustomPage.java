package com.example.socialfunnel;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Notification;

public abstract class CustomPage extends CustomComponent implements UpdateableView {

	public abstract void enter(ViewChangeEvent event);
	public abstract void update();
	public abstract void resizeView(int width, int height);
	
	public CustomPage() {

	}
	
	public void show(final String content, final Notification.Type type){
		getUI().access(new Runnable() {
			
			@Override
			public void run() {
				Notification.show(content, type);
				getUI().push();
			}
		});
	}
}

interface UpdateableView extends View {
	public void update();
}
