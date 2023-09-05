package projects;

public class Step {

	

	    
	    private Integer stepId;           
	    private Integer projectId;        
	    private String stepText;         
	    private Integer stepOrder;        

	    
	    public Step() {}

	    // Constructor with all fields
	    public Step(Integer stepId, Integer projectId, String stepText, Integer stepOrder) {
	        this.stepId = stepId;
	        this.projectId = projectId;
	        this.stepText = stepText;
	        this.stepOrder = stepOrder;
	    }

	    // Getters and setters

	    public Integer getStepId() {
	        return stepId;
	    }

	    public void setStepId(Integer stepId) {
	        this.stepId = stepId;
	    }

	    public Integer getProjectId() {
	        return projectId;
	    }

	    public void setProjectId(Integer projectId) {
	        this.projectId = projectId;
	    }

	    public String getStepText() {
	        return stepText;
	    }

	    public void setStepText(String stepText) {
	        this.stepText = stepText;
	    }

	    public Integer getStepOrder() {
	        return stepOrder;
	    }

	    public void setStepOrder(Integer stepOrder) {
	        this.stepOrder = stepOrder;
	    }

	    // You can also override the toString() method to display the object details

	    @Override
	    public String toString() {
	        return " stepId= " + stepId + ", projectId= " + projectId + ", stepText=  "   + stepText +  ", stepOrder= "
	                + stepOrder +  "";
	    }
	}


