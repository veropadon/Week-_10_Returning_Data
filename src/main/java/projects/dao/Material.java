
	
	package projects.dao;

	public class Material {

	    private Integer materialId;  
	    private Integer projectId; 
	    private String materialName; 
	    private Integer numRequired; 
	    private Double cost;         

	    // Constructors
	    public Material() {
	    }

	    public Material(Integer materialId, Integer projectId, String materialName, Integer numRequired, Double cost) {
	        this.materialId = materialId;
	        this.projectId = projectId;
	        this.materialName = materialName;
	        this.numRequired = numRequired;
	        this.cost = cost;
	    }

	    // Getters and Setters
	    public Integer getMaterialId() {
	        return materialId;
	    }

	    public void setMaterialId(Integer materialId) {
	        this.materialId = materialId;
	    }

	    public Integer getProjectId() {
	        return projectId;
	    }

	    public void setProjectId(Integer projectId) {
	        this.projectId = projectId;
	    }

	    public String getMaterialName() {
	        return materialName;
	    }

	    public void setMaterialName(String materialName) {
	        this.materialName = materialName;
	    }

	    public Integer getNumRequired() {
	        return numRequired;
	    }

	    public void setNumRequired(Integer numRequired) {
	        this.numRequired = numRequired;
	    }

	    public Double getCost() {
	        return cost;
	    }

	    public void setCost(Double cost) {
	        this.cost = cost;
	    }

	    @Override
	    public String toString() {
	        return "Id=" + materialId + 
	                ", materialName=" + materialName + 
	                ", numRequired=" + numRequired + 
	                ", cost=" + cost;
	        
	     }
	    }
	


