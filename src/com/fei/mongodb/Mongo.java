package com.fei.mongodb;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mongo {
	
	private static final int range= 10000;
	private static MongoClient client = new MongoClient();
	private static MongoDatabase database = client.getDatabase("dongserver");
	private static MongoCollection<Document> collection = database.getCollection("position");
	
	
	// 插入一条文档
	public static void insertOneDoc (String userId,double x,double y){
		Document document = new Document();
		document.append("userId", userId).append("posi",new Document().append("type","Point").append("coordinates", new Document().append("x",x).append("y", y)));
		collection.insertOne(document);
	}
	
	// 获取一定距离位置内的人
	public static String getRangePer(double x,double y){
		String result = null;
		Document dc = database.runCommand(new Document("geoNear","position").append("near", new Document().append("type","Point").append("coordinates", new Document().append("x",x).append("y", y))).append("spherical", true).append("maxDistance", range));// 单位是米 有5 米的误差
		//System.out.println("dcdcdcdcd:" + dc.toJson());
		result = dc.toJson();
		return result;
	}

}
