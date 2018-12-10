package Algorithm;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class Query {

    Firestore db;                       // create firestore connection at instantiatino
    private userPreferences prefs;      //
    ArrayList<course> courses;          // desired courses


    public Query(){
        //this.prefs = prefs;
        try {
            System.out.println(System.getProperty("user.dir"));
            FileInputStream serviceAccount = new FileInputStream( System.getProperty("user.dir") + ("/src/Algorithm/ofCourse-18db9e6c8815.json"));
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setProjectId("ofcourse-225107")
                    .build();
            FirebaseApp.initializeApp(options);
            this.db = FirestoreClient.getFirestore();
        } catch(java.io.IOException e) { System.out.println("There was an issue setting up the db line:27"); }
    }

    public ArrayList<String> getCourseSections(String abbreviation) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException {
        ArrayList<String> sections = new ArrayList<String>();
        DocumentReference docRef = db.collection("courses").document(abbreviation);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();

        sections.addAll((List<String>)document.getData().get("sections"));

        return sections;
    }

    public Section makeSection(String section) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException{
        DocumentReference docRef = db.collection("sections").document(section);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();

        String days = (String)document.getData().get("lecture-days");
        String start = (String)document.getData().get("lecture-start");
        String end = (String)document.getData().get("lecture-end");
        String prefix = (String)document.getData().get("prefix");
        String number = (String)document.getData().get("number");
        double rating = Double.parseDouble((String)document.getData().get("rmp-rating"));
        Section ret = new Section(Integer.parseInt(section), days, start, end, prefix + " " + number, rating);
        return ret;
    }

    public ArrayList<Professor> searchProfessors(String lastName)throws java.lang.InterruptedException, java.util.concurrent.ExecutionException{
        DocumentReference docRef = db.collection("professors").document(lastName);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        DocumentSnapshot document = future.get();
        ArrayList<Professor> profs = new ArrayList<Professor>();
        int length = ((List<String>)(document.getData().get("professor-first-initials"))).size();
        for (int i = 0; i < length; i++) {
            profs.add(new Professor(lastName,
                    ((List<String>)(document.getData().get("professor-first-initials"))).get(i),
                    ((List<String>)(document.getData().get("sections"))).get(i)));
        }
        return profs;
    }

}
