package EnocaCrud.EnocaCrud.core.results;


public class SuccesResult extends Result {

	public SuccesResult() {
		super(true);
	}

	public SuccesResult(String message) {
		super(true, message);

	}

}