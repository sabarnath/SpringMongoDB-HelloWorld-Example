 
import java.io.File;
import java.io.IOException;
 
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.WriteConcern;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
 
public class GRIDFSSample {
 
 
	public static void main(String[] args) throws IOException {
 
		//
		// Connect to MongoDB (without authentification for the time being)
		// And get a handle on the collection used to store the metadata
		//
		Mongo mongo = new Mongo("localhost", 27017);
		DB db = mongo.getDB("test");
		DBCollection collection = db.getCollection("downloads_meta");
 
		//
		// The biiiiig file to be stored to MongoDB
		//
		File file = new File("/home/smi-user/Doc_design_for_postgress.odt");
 
		//
		// Store the file to MongoDB using GRIDFS
		//
		//GridFS gridfs = new GridFS(db, "downloads");
		//GridFS gridfs = new GridFS(db, ".");
		GridFS gridfs = new GridFS(db, "");
		GridFSInputFile gfsFile = gridfs.createFile(file);
		gfsFile.setFilename("Doc_design_for_postgress");
		gfsFile.save();
 
		//
		// Let's create a new JSON document with some "metadata" information on the download
		//
		BasicDBObject info = new BasicDBObject();
                info.put("name", "MongoDB");
                info.put("fileName", "Doc_design_for_postgress");
                info.put("rawName", "Doc_design_for_postgress.odt");
                info.put("rawPath", "/home/smi-user/");
 
                //
                // Let's store our document to MongoDB
                //
		collection.insert(info, WriteConcern.SAFE);
	}	
}