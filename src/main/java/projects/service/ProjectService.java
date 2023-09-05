package projects.service;

import java.util.ArrayList;

import java.util.List;

import java.util.NoSuchElementException;


import projects.Project;
import projects.dao.Material;
import projects.dao.ProjectDao;
import projects.exception.DbException;




public class ProjectService {
	

	private ProjectDao  projectDao =  new ProjectDao();

	

 public Project addProject(Project project) {
	 
			return projectDao.insertProject(project);
			
			
		
	}
		
	
	public List<Project> fetchAllProjects()  {
		return projectDao.fetchAllProjects();


	}



		public Project  fetchProjectById(Integer projectId) {
			
			
			try {
				return projectDao.fetchProjectById(projectId).orElseThrow(
						() -> new NoSuchElementException(" Project with project ID = " + projectId + " does not exist "));
				
			
			
			}
	
		
			catch (Exception e) {
				throw new DbException(e);
				
		    }
		}


		public List<Material> fetchMaterialsForProject(int projectId) {
			
		
			        List<Material> materials = new ArrayList<>();
			        if(projectId == 1) {
			            materials.add(new Material(1, 1, "Door in frame", 1, null));
			            materials.add(new Material(2, 1, "2-inch screws", 20, 0.5));
			        }
			        return materials;
			    }


		public void addMaterialToProject(Material material) {
			System.out.println("Added Material Details:");
	        System.out.println("material Id=" + material.getMaterialId());
	        System.out.println("materialName = " + material.getMaterialName());
	        System.out.println("numRequired = " + material.getNumRequired());
	        System.out.println("cost = " + material.getCost());
	    }
	
	

		
		public void printCategoriesForProject(int projectId) {
		    Project project = fetchProjectById(projectId);
		    if (project != null) {
		        List<projects.Category> categories = project.getCategories();
		        if (categories.isEmpty()) {
		            System.out.println("No categories found for this project.");
		        } else {
		            System.out.print("Categories for the project are: ");
		            for (projects.Category category : categories) {
		                System.out.printf("Id = %d, categoryName = %s    ", category.getCategoryId(), category.getCategoryName());
		            }
		            System.out.println(); // Just to print a newline at the end
		        }
		    } else {
		        System.out.println("Project with ID = " + projectId + " does not exist.");
		    }
		}
}



		
		
			
		
			

			
		


		

				
		
			
		
		


			
			
			

		

					
					


