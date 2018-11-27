
public class Review {
	private String source;
	private RatingType ratingType;
	
	Review(String source, RatingType ratingType){
		this.source = source;
		this.ratingType = ratingType;
	}
	
	String getSource() {
		return source;
	}
	
	int getRating() {
		return ratingType.getRating();
	}
	

	
	boolean update(String source, int rating) {
		if(!this.source.equals(source)) {
			return false;
		}
		
		ratingType.setScore(rating);
		
		return true;
	}
}

