package com.nimma.jersey.client;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import java.util.ArrayList;


public class ClientSide {
	
	//Main method - init
	public static void main(String[] args) {
		
		MongoClientSide mcs = new MongoClientSide();
		
		//CRUD - create
		mcs.CreateClientData(1, "breakfast", "40% off", "kellogs");
		//push using "read"
		
		
		//CRUD - read
		ArrayList<String> new_data = mcs.ReadClientData();
		//Only push if there is data already
		if(new_data.size() > 0){
		
			pushToServer(new_data, "read");
		}
	
		/*U-update
		ArrayList<String> new_data = mcs.UpdateClientData("kellogs", "90% off");
		System.out.println(new_data);
		pushToServer(new_data, "update"); //set true for updates
		*/
		
		//Delete
		//ArrayList<String> new_data = mcs.DeleteClientData("kellogs");
		//pushToServer(new_data, "delete");
		
		
	}
	
//Push data to server
public static void pushToServer(ArrayList<String> items_collections, String crud){
	try {
		
		String[]  items = new String [items_collections.size()];
		items_collections.toArray(items);
		
		//Setup client
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/com.nimma.jersey.server/rest");
		
				
		for( String single_item: items){
			
			Response r2;
			
			System.out.println(single_item);
			
			//Handle response
			System.out.println("JSON from client : " + single_item);
			
			if(crud == "read"){ //for create and read
				
				 r2 = target.path("/posts").request(MediaType.APPLICATION_JSON_TYPE).post(
					Entity.entity(single_item, MediaType.APPLICATION_JSON_TYPE));
			}
			else if (crud == "delete") { //for deleting server data
				r2 = target.path("/update").path("/delete").request(MediaType.APPLICATION_JSON_TYPE).post(
						Entity.entity(single_item, MediaType.APPLICATION_JSON_TYPE));
		
			}
			else if (crud == "update"){ //for updates
				
				 r2 = target.path("/update").request(MediaType.APPLICATION_JSON_TYPE).post(
						Entity.entity(single_item, MediaType.APPLICATION_JSON_TYPE));
			}
			else{
				return; //invalid input, give up
			}
	
			//Output
			System.out.println("Server response:");
			System.out.println(r2.readEntity(String.class));
			System.out.println("---------------------------");
		}

		
	} catch (Exception e) { //Worst case sanity check
			e.printStackTrace();
		} 
	}

}



