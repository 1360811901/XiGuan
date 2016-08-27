package com.fei.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.bson.Document;

import com.fei.Entity.Position;
import com.fei.redis.MongodbDAOImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Filters.*;
import com.mongodb.client.model.geojson.Geometry;

public class MongoTest {

	public static void main(String[] args) {
		MongoClient client = new MongoClient();
		MongoDatabase database = client.getDatabase("dongserver");
		MongoCollection<Document> collection = database.getCollection("position");
		
		// insert a document
		//Document document = new Document("x", 1);
		//collection.insertOne(document);
		//document.append("x", 116.64947).append("y", 39.911393);

		Document document2 = new Document("userId","1825359784sdf");
		document2.append("posi",new Document().append("type","Point").append("coordinates", new Document().append("x",116.391333).append("y", 39.921133)));
		collection.insertOne(document2);
		// replace a document
		
		/*Document document3 = new Document();
		document3.append("userId", "18253597849");
		document3.append("posi", new double[]{116.402257,39.925117});
		document3.append("name", 3);
		
		//document3.append("posi", new BasicDBObject("y",39.915378));
		collection.insertOne(document3);*/
		//collection.replaceOne(Filters.eq("_id", document.get("_id")), document);
		FindIterable<Document> rss = collection.find(Filters.geoWithinCenter("posi", 116.408581, 39.915378, 1000/112.1));
		Document dc = database.runCommand(new Document("geoNear","position").append("near", new Document().append("type","Point").append("coordinates", new Document().append("x",116.348215).append("y", 39.930871))).append("spherical", true).append("maxDistance", 100000));// 单位是米 有5 米的误差
		System.out.println("dcdcdcdcd:" + dc.toJson());
		
		MongoCursor<Document> cursor = rss.iterator();
		try {
		    while (cursor.hasNext()) {
		    	System.out.println("sssssssss");
		        System.out.println("result:" + cursor.next().toJson());
		    }
		} finally {
		    cursor.close();
		}
		// find documents
		List<Document> foundDocument = collection.find().into(new ArrayList<Document>());
		
		for(int i =0;i<foundDocument.size();i++){
			System.out.println(foundDocument.get(i).toJson());
		}
		
		/*BasicDBObject mydata = new BasicDBObject(); 
		mydata.put("userId", "18253594651");
		mydata.put("posi", new double[]{116.402257,39.925117});
		
		Document document = new Document();
		double[] ds = {116.402257,39.925117};
		document.append("posi",ds);
		//collection.insertOne(document);
		
		BasicDBObject myCmd = new BasicDBObject(); 
		myCmd.append("geoNear", collection); 
		double[] loc = {116.462335,39.94791}; 
		myCmd.append("near", loc); 
		myCmd.append("spherical", true); 
		myCmd.append("maxDistance", (double)50 / 3959 ); 
		//System.out.println(myCmd.toJson()); 
		//Document myResults = database.runCommand(myCmd); 
		//System.out.println(myResults.toString());
		
		// find documents
		List<Document> foundDocument = collection.find().into(new ArrayList<Document>());
		
		for(int i =0;i<foundDocument.size();i++){
			System.out.println(foundDocument.get(i).toJson());
		}*/

	}

}
