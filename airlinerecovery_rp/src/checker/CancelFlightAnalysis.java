package checker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import sghku.tianchi.IntelligentAviation.common.Parameter;
import sghku.tianchi.IntelligentAviation.entity.Flight;
import sghku.tianchi.IntelligentAviation.entity.Scenario;

public class CancelFlightAnalysis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parameter.isReadFixedRoutes = false;
		Scenario scenario = new Scenario(Parameter.EXCEL_FILENAME);
		
		try {
			Scanner sn = new Scanner(new File("cancelflight"));
			while(sn.hasNextLine()) {
				String nextLine = sn.nextLine().trim();
				
				if(nextLine.equals("")) {
					break;
				}
				
				Scanner innerSn = new Scanner(nextLine);
				int fId = innerSn.nextInt();
				
				Flight f = scenario.flightList.get(fId-1);
				
				if(!f.isDomestic) {
					System.out.println("international flight "+f.id+"  "+f.isIncludedInConnecting+"  "+f.importance*Parameter.COST_CANCEL+" "+f.passengerNumber+" "+f.connectedPassengerNumber+" "+f.leg.originAirport+"->"+f.leg.destinationAirport+" "+f.takeoffTime+"->"+f.landingTime);
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
