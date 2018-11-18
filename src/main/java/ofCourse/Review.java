package ofCourse;

public class Review {
	private String source;
	private int rating;
	private int ratingScale;
	private int fixedRating;
	
	Review(String source, int rating, int ratingScale){
		this.source = source;
		this.rating = rating;
		this.ratingScale = ratingScale;
	}
	
	String getSource() {
		return source;
	}
	
	int getRating() {
		return rating;
	}
	
	int getRatingScale() {
		return ratingScale;
	}
	
	int getFixedRating() {
		return fixedRating;
	}
	
	boolean update(String source, int rating, int ratingScale) {
		if(!this.source.equals(source)) {
			return false;
		}
		
		this.rating = rating;
		this.ratingScale = ratingScale;
		
		return true;
	}
}

