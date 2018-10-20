import java.util.ArrayList;
public class Professor {
	private String name;
	private ArrayList<Review> reviews;
	
	Professor(String name){
		this.name = name;
	}
	
	
	public void updateReview(Review oldReview, Review newReview) {
		for(int i = 0; i < reviews.size() ; i++) {
			Review cmpReview = reviews.get(i);
			
			if(cmpReview.equals(oldReview)){
				reviews.set(i, newReview);
				return;
			}
		}
		
		reviews.add(newReview);
	}
}
