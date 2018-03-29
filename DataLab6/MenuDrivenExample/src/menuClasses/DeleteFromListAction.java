package menuClasses;

import dataManager.DMComponent;
import ioManagementClasses.IOComponent;

public class DeleteFromListAction implements Action {

	@Override
	public void execute(Object args) {
		IOComponent io = IOComponent.getComponent(); 
		DMComponent dm = (DMComponent) args; 
		dm.showListsNames();
		int value = Integer.parseInt(io.getInput("Enter the value to delete: ")); 
		dm.removeList(value-1); 
	}

}
