package bean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDBDataStoreUtilities {

	private MongoDBDataStoreUtilities() {
	}

	private static MongoDBDataStoreUtilities instance = new MongoDBDataStoreUtilities();

	public static void insertReview(String price, String name, String producttype, Double reviewrating,
			String reviewdate, String reviewtext, String retailerZip, String retailerState, String productOnSale,
			String manufacturerName, String manufacturerRebate, String age, String gender, String occupation,
			String username, String date, String productreview) {
		// getConnection();
		DBCollection ReviewsData;
		MongoClient mongo;
		DB db;
		mongo = new MongoClient("localhost", 27017);
		db = mongo.getDB("CustomerReviews");
		ReviewsData = db.getCollection("ReviewsData");
		BasicDBObject doc = new BasicDBObject("title", "ReviewsData").append("productname", name)
				.append("price", Integer.parseInt(price)).append("producttype", producttype)
				.append("reviewrating", reviewrating).append("reviewdate", reviewdate).append("reviewtext", reviewtext)
				.append("retailerZip", retailerZip).append("retailerState", retailerState)
				.append("productOnSale", productOnSale).append("manufacturerName", manufacturerName)
				.append("manufacturerRebate", manufacturerRebate).append("age", age).append("gender", gender)
				.append("occupation", occupation).append("username", username).append("rating", reviewrating)
				.append("date", date).append("productreview", productreview);
		ReviewsData.insert(doc);

	}

	// db.Reviews.aggregate([{$group : {_id : "$productname", Average : {$avg
	// : "$rating"}}}])
	public static ArrayList<HashMap<String, Double>> getBestratedproduct() {
		ArrayList<HashMap<String, Double>> arrayofbestratedproduct = new ArrayList<>();

		DBCollection ReviewsData;
		MongoClient mongo;
		DB db;
		mongo = new MongoClient("localhost", 27017);
		db = mongo.getDB("CustomerReviews");
		ReviewsData = db.getCollection("ReviewsData");
		ArrayList<HashMap<String, String>> arrayofmongodata = new ArrayList<>();

		/*
		 * db.Reviews.aggregate([{$group : {_id : "$productname", Average :
		 * {$avg : "$rating"}}},{$sort: {Average: -1}},{ $limit : 2 }])
		 */

		// Creating an Object for the query
		final DBObject groupInnerFields = new BasicDBObject("_id", "$productname");
		groupInnerFields.put("Average", new BasicDBObject("$avg", "$rating"));
		final DBObject groupIdFields = new BasicDBObject("$group", groupInnerFields);
		final DBObject sortInnerFields = new BasicDBObject("Average", -1);

		// sorting
		final DBObject sortIdFields = new BasicDBObject("$sort", sortInnerFields);

		// Limit is 5 product
		final DBObject limitIdFields = new BasicDBObject("$limit", 5);

		final AggregationOutput aggregate = ReviewsData.aggregate(groupIdFields, sortIdFields, limitIdFields);

		// Placing aggregated output in iterator
		Iterable<DBObject> list = aggregate.results();
		Iterator<DBObject> iterator = list.iterator();

		while (iterator.hasNext()) {
			HashMap<String, Double> bestratedHashmap = new HashMap<String, Double>();
			DBObject obj = iterator.next();

			String id = (String) obj.get("_id");

			Double rating = (Double) obj.get("Average");

			bestratedHashmap.put(id, rating);

			arrayofbestratedproduct.add(bestratedHashmap);
			System.out.println(arrayofbestratedproduct);

		}
		return arrayofbestratedproduct;
	}

	public static ArrayList<HashMap<String, Integer>> getBestnonRatedproduct() {
		ArrayList<HashMap<String, Integer>> arrayofbestNonratedproduct = new ArrayList<>();

		DBCollection ReviewsData;
		MongoClient mongo;
		DB db;
		mongo = new MongoClient("localhost", 27017);
		db = mongo.getDB("CustomerReviews");
		ReviewsData = db.getCollection("ReviewsData");
		ArrayList<HashMap<String, String>> arrayofmongodata = new ArrayList<>();

		/*
		 * db.Reviews.aggregate([{$group : {_id : "$productname", rating : {$sum
		 * : 1}}},{$sort: {rating:-1}},{ $limit : 5 }])
		 */

		// Creating an Object for the query
		final DBObject groupInnerFields = new BasicDBObject("_id", "$productname");
		groupInnerFields.put("rating", new BasicDBObject("$sum", 1));
		final DBObject groupIdFields = new BasicDBObject("$group", groupInnerFields);
		final DBObject sortInnerFields = new BasicDBObject("rating", -1);

		// sorting
		final DBObject sortIdFields = new BasicDBObject("$sort", sortInnerFields);

		// Limit is 5 product
		final DBObject limitIdFields = new BasicDBObject("$limit", 5);

		final AggregationOutput aggregate = ReviewsData.aggregate(groupIdFields, sortIdFields, limitIdFields);

		// Placing aggregated output in iterator
		Iterable<DBObject> list = aggregate.results();
		Iterator<DBObject> iterator = list.iterator();

		while (iterator.hasNext()) {
			HashMap<String, Integer> bestratedHashmap = new HashMap<String, Integer>();
			DBObject obj = iterator.next();
			System.out.println(obj);
			String id = (String) obj.get("_id");

			int rating = (int) obj.get("rating");

			bestratedHashmap.put(id, rating);

			arrayofbestNonratedproduct.add(bestratedHashmap);
			System.out.println(arrayofbestNonratedproduct);

		}
		return arrayofbestNonratedproduct;
	}

	public static ArrayList<HashMap<String, Integer>> getBestlocation() {
		ArrayList<HashMap<String, Integer>> arrayofbestZipCoderatedproduct = new ArrayList<>();
		DBCollection ReviewsData;
		MongoClient mongo;
		DB db;
		mongo = new MongoClient("localhost", 27017);
		db = mongo.getDB("CustomerReviews");
		ReviewsData = db.getCollection("ReviewsData");
		ArrayList<HashMap<String, Integer>> arrayofbestratedproduct = new ArrayList<>();

		/*
		 * db.Reviews.aggregate([{$group : {_id : "$productname", rating : {$sum
		 * : 1}}},{$sort: {rating:-1}},{ $limit : 5 }])
		 */

		// Creating an Object for the query
		final DBObject groupInnerFields = new BasicDBObject("_id", "$retailerZip");
		groupInnerFields.put("rating", new BasicDBObject("$sum", 1));
		final DBObject groupIdFields = new BasicDBObject("$group", groupInnerFields);
		final DBObject sortInnerFields = new BasicDBObject("rating", -1);

		// sorting
		final DBObject sortIdFields = new BasicDBObject("$sort", sortInnerFields);

		// Limit is 5 product
		final DBObject limitIdFields = new BasicDBObject("$limit", 5);

		final AggregationOutput aggregate = ReviewsData.aggregate(groupIdFields, sortIdFields, limitIdFields);

		// Placing aggregated output in iterator
		Iterable<DBObject> list = aggregate.results();
		Iterator<DBObject> iterator = list.iterator();

		while (iterator.hasNext()) {
			HashMap<String, Integer> bestratedHashmap = new HashMap<String, Integer>();
			DBObject obj = iterator.next();

			String id = (String) obj.get("_id");

			Integer rating = (Integer) obj.get("rating");

			bestratedHashmap.put(id, rating);

			arrayofbestZipCoderatedproduct.add(bestratedHashmap);
			System.out.println(arrayofbestZipCoderatedproduct);

		}
		return arrayofbestZipCoderatedproduct;
	}

	public static ArrayList<HashMap<String, String>> getallReviews() {
		// getConnection();
		DBCollection ReviewsData;
		MongoClient mongo;
		DB db;
		mongo = new MongoClient("localhost", 27017);
		db = mongo.getDB("CustomerReviews");
		ReviewsData = db.getCollection("ReviewsData");
		ArrayList<HashMap<String, String>> arrayofmongodata = new ArrayList<>();

		DBCursor cursor = ReviewsData.find();
		while (cursor.hasNext()) {
			HashMap<String, String> reviewHashmap = new HashMap<String, String>();
			BasicDBObject obj = (BasicDBObject) cursor.next();
			reviewHashmap.put("productName", obj.getString("productname"));
			reviewHashmap.put("price", obj.getString("price"));
			reviewHashmap.put("producttype", obj.getString("producttype"));
			reviewHashmap.put("reviewrating", obj.getString("reviewrating"));
			reviewHashmap.put("reviewtext", obj.getString("reviewtext"));
			reviewHashmap.put("retailerZip", obj.getString("retailerZip"));
			reviewHashmap.put("retailerState", obj.getString("retailerState"));
			reviewHashmap.put("productOnSale", obj.getString("productOnSale"));
			reviewHashmap.put("manufacturerName", obj.getString("manufacturerName"));
			reviewHashmap.put("manufacturerRebate", obj.getString("manufacturerRebate"));
			reviewHashmap.put("age", obj.getString("age"));
			reviewHashmap.put("gender", obj.getString("gender"));
			reviewHashmap.put("occupation", obj.getString("occupation"));
			reviewHashmap.put("username", obj.getString("username"));
			reviewHashmap.put("rating", obj.getString("rating"));
			reviewHashmap.put("date", obj.getString("date"));
			reviewHashmap.put("productreview", obj.getString("productreview"));
			arrayofmongodata.add(reviewHashmap);

		}
		return arrayofmongodata;
	}

	public static MongoDBDataStoreUtilities getInstance() {
		if (instance == null) {
			instance = new MongoDBDataStoreUtilities();
		}
		return instance;
	}

	/* Analytics Part */
	// 1.
	// Print the list of all products and their ratings
	// db.myReviews.aggregate([{$group : {_id : "$productname", Average : {$avg
	// : "$rating"}}},{$sort: {Average: -1}}])

	public static ArrayList<HashMap<String, Double>> getBestratedproductwithoutLimit() {
		ArrayList<HashMap<String, Double>> arrayofbestratedproduct = new ArrayList<>();
		DBCollection ReviewsData;
		MongoClient mongo;
		DB db;
		mongo = new MongoClient("localhost", 27017);
		db = mongo.getDB("CustomerReviews");
		ReviewsData = db.getCollection("ReviewsData");
		ArrayList<HashMap<String, String>> arrayofmongodata = new ArrayList<>();
		// Creating an Object for the query
		final DBObject groupInnerFields = new BasicDBObject("_id", "$productname");
		groupInnerFields.put("Average", new BasicDBObject("$avg", "$rating"));
		final DBObject groupIdFields = new BasicDBObject("$group", groupInnerFields);
		final DBObject sortInnerFields = new BasicDBObject("Average", -1);

		// sorting
		final DBObject sortIdFields = new BasicDBObject("$sort", sortInnerFields);

		final AggregationOutput aggregate = ReviewsData.aggregate(groupIdFields, sortIdFields);

		// Placing aggregated output in iterator
		Iterable<DBObject> list = aggregate.results();
		Iterator<DBObject> iterator = list.iterator();

		while (iterator.hasNext()) {
			HashMap<String, Double> bestratedHashmap = new HashMap<String, Double>();
			DBObject obj = iterator.next();

			String id = (String) obj.get("_id");

			Double rating = (Double) obj.get("Average");

			bestratedHashmap.put(id, rating);

			arrayofbestratedproduct.add(bestratedHashmap);
			System.out.println(arrayofbestratedproduct);

		}
		return arrayofbestratedproduct;
	}

}