import java.net.UnknownHostException;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.util.JSON;

//import com.mongodb.*;
//import com.mongodb.util.JSON;
//
//import org.json.simple.*;
//import java.util.*;
//import java.io.*;
//import java.net.UnknownHostException;
public class Mongo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MongoClient mc = null;
		//String dbURI="mongodb://sangat:password@192.168.1.7:27017/dbmsc1";
		try {
			mc = new MongoClient("192.168.1.7:27017",27017);
			//mc = new MongoClient(new MongoClientURI(dbURI));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DB db = mc.getDB("dbmsc1");
		
		db.authenticate("sangat", "password".toCharArray());
		
		//DBCollection dbc = db.getCollection("student");
		
		Scanner sc = new Scanner(System.in);
		int opt=0;
		while(opt!=5)
		{
			System.out.println("Choose operation: ");
			System.out.println("1.Create");
			System.out.println("2.Read");
			System.out.println("3.Update");
			System.out.println("4.Delete");
			System.out.println("Choose option: ");
			
			opt = sc.nextInt();
			DBCollection dbc = db.getCollection("student");
			
			switch(opt)
			{
			case 1:
				BasicDBObject obj = new BasicDBObject();
				obj.append("name", "Sangat");
				obj.append("sex","male");
				JSONArray arr = new JSONArray();
				arr.add("swimming");
				arr.add("coding");
				arr.add("problem solving");
				arr.add("watching movies");
				obj.append("hobbies",arr);
				dbc.insert(new DBObject[] {obj});
				break;
				
			case 2:
				DBCursor dbcur = dbc.find();
				while(dbcur.hasNext())
				{
					System.out.println(dbcur.next());
				}
				break;
			
			case 3:
				BasicDBObject upobj = new BasicDBObject();
				upobj.append("$set", new BasicDBObject().append("hobbies.1", "porn"));
				BasicDBObject query = new BasicDBObject();
				query.append("name", "Sangat");
				dbc.update(query, upobj);
				break;
			case 4:
				BasicDBObject remobj = new BasicDBObject();
				remobj.append("name", "Sangat");
				dbc.remove(remobj);
				break;
			
			case 5:
				break;
			
			default:
				System.out.println("Invalid option");
			}
		}
//		DBCollection dbc = db.getCollection("student");
//		
//		JSONObject jobj = new JSONObject();
//		jobj.put("Rollno", "3165");
//		jobj.put("sex", "male");
//		
//		JSONObject jobj1 = new JSONObject();
//		jobj1.put("score","67");
//		jobj1.put("sub", "toc");
//		
//		JSONObject jobj2 = new JSONObject();
//		jobj2.put("score","56");
//		jobj2.put("sub","dbms");
//		
//		JSONObject jobj3 = new JSONObject();
//		jobj3.put("score","98");
//		jobj3.put("sub","cn");
//		
//		JSONArray arr = new JSONArray();
//		arr.add(jobj1);
//		arr.add(jobj2);
//		arr.add(jobj3);
//		
//		jobj.put("Marks", arr);
//		System.out.println("This is JSON Object"+jobj);
//		
//		DBObject dbobj = (DBObject) JSON.parse(jobj.toString());
//		
//		dbc.save(dbobj);
//		
//		System.out.println("Data inserted successfully!!");
//		
//		DBCursor cur1 = dbc.find();
//		
//		while(cur1.hasNext())
//		{
//			System.out.println(cur1.next());
//		}
//		
//		
//	}

}}
