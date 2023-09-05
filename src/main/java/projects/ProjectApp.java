package projects;

import java.math.BigDecimal;


import java.util.List;

import java.util.Objects;
import java.util.Scanner;

import projects.dao.Material;
import projects.exception.DbException;
import projects.service.ProjectService;

public class ProjectApp {
	


private Scanner scanner  = new Scanner (System.in);
   
   private ProjectService projectService = new ProjectService();
   private Project curProject;
   
   


	
	
		
		// @formatter : off 
		
		private   List<String>  operations = List.of(
				
				"1) Add a project " ,
				"2) List projects " ,
			
			 "3) Select a project" , 
				
				"4) Add a material to the selected project",
				
			    "5) List materials for the selected project"
			);
		
					
				
				
		
		// @formatter : on 
		
		
			
	
	
		
			
			
			
			
		
		
		
		private void processUserSelections()  {
			
			boolean done = false;
			while(! done) {
				
				try {
					
					int selection = getUserSelection();
					
					switch (selection) {
					case -1:
						done = exitMenu();
						break;
						
					case 1:
						createProject();
						break;
						
					case 2:
						listProjects();
						break;
				
						
					case 3:
				        selectProject();
				        break;
						
				        
					case 4:
					    addMaterialToCurrentProject();
					    break;
					case 5:
					    listMaterialsForCurrentProject();
					    break;
						
						default:
							System.out.println("\n" + selection + " is not a valid selection. Try again");
							break;
							
							
							
							
							
					}
					
				
				}
				
				catch (Exception e) {
					System.out.println("\nAn error ocurred: " + e + "Try again. " );
					  e.printStackTrace();
				}
			}
		}
		
		

				
			
			
	
		
		

		
		
		
			
			private void addMaterialToCurrentProject() {
				
				
				    if(curProject == null) {
				        System.out.println("\nPlease select a project first.");
				        return;
				    }
				    System.out.println("\nAdd Material to " + curProject.getProjectName() + ":");
				    Integer materialId = getIntInput("Enter material Id");
				    String materialName = getStringInput("Enter material name");
				    Integer numRequired = getIntInput("Enter number required");
				    // Assuming your Material class accepts null values for Double (cost), and that's why you're not asking for cost input.
				    Material material = new Material(materialId, curProject.getProjectId(), materialName, numRequired, null);
				    // You'd need a method in projectService to add the material. 
				    // This is an assumed method. You will need to implement it.
				    projectService.addMaterialToProject(material);
				    System.out.println("\nMaterial added.");
				}

				private void listMaterialsForCurrentProject() {
				    if(curProject == null) {
				        System.out.println("\nPlease select a project first.");
				        return;
				    }
				    System.out.println("\nMaterials for " + curProject.getProjectName() + ":");
				    // This is an assumed method. You will need to implement it.
				    List<Material> materials = projectService.fetchMaterialsForProject(curProject.getProjectId());
				    for(Material material : materials) {
				        System.out.println(material);
				    }
				}

			
		














			private void selectProject() {
		
			   listProjects();
			   Integer projectId = getIntInput(" Enter a project Id to select a project ");
			   
			   curProject = projectService.fetchProjectById(projectId);
			   
			   
		
			  
			}




			private void createProject() {
				
				
					
					String projectName = getStringInput( "Enter the project name");
					BigDecimal estimatedHours = getDecimalInput("Enter the estimated hours");
					BigDecimal actualHours = getDecimalInput (" Enter the actual hours");
					Integer difficulty = getIntInput(" Enter the project difficulty (1- 5)");
					String notes = getStringInput ("Enter the project notes");
					
					Project project = new Project();
					project.setProjectName(projectName);
					project.setEstimatedHours(estimatedHours);
					project.setActualHours(actualHours);
					project.setDifficulty(difficulty);
					project.setNotes (notes);
					
					Project dbProject = projectService.addProject(project);
					System.out.println(" You have successfully created project: " + dbProject);
					
					
				}
			
				
			

			
				private BigDecimal getDecimalInput(String prompt) {
					
					String input = getStringInput(prompt) ;
						if(Objects.isNull(input)) {
							return null;
							
						}
						
				        try {
				        	
				    
				    return new BigDecimal(input).setScale(2);
				        	
				         } catch (NumberFormatException e) {
				             throw new DbException("Invalid input. Please enter a valid decimal number.");
				         }
				     }
				 
			





			private Integer getIntInput(String prompt) {
				
				String input = getStringInput(prompt) ;
				if(Objects.isNull(input)) {
					return null;
							
				}
				
		
			        try {
			          
			            return Integer.valueOf(input);
			            
			        } catch (NumberFormatException e) {
			        	throw new DbException (input + "is not a valid number. ");
			        	
			        }
			            
			     
			    }
			
			private String getStringInput(String prompt) {
				System.out.println(prompt + ":  ");
				
				String input = scanner.nextLine();
				
				return input.isBlank() ? null : input.trim();
				
			}
			
			        
			





			private boolean exitMenu() {
			    System.out.println("Thank you for using the Project App. Exiting...");
			   

			    scanner.close(); 

			    return true; // Indicating that we wish to exit
			}

			
		





		private int getUserSelection() {
			printOperations();
			Integer input = getIntInput("\n Enter a menu selection");
			return  Objects.isNull(input)  ? -1 : input;
		}






		
			private void printOperations() {
			    System.out.println("\nAvailable Operations:");
			   
			    for (String operation : operations) {
			        System.out.println(operation);
			    }

			  
			    if (Objects.isNull(curProject)) {
			        System.out.println("\nYou are not currently working with any project.");
			    } else {
			        System.out.println("\nYou are currently working with project: " + curProject);
			    }
			

			}



		public static void main(String[] args) {
		    ProjectApp app = new ProjectApp();
		    app.processUserSelections();
		} 
		
		
		
		 

	



		private void listProjects() {
		   
      List<Project> projects = projectService.fetchAllProjects() ;	
		
		    
		    System.out.println("\nProjects: ");
		    
		   

		    projects.forEach(project ->  System.out.println("    " + project.getProjectId() + ":  " + project.getProjectName())
		    );
		
		
		}
		
		
}


		
		
				
		
		
		
		
		
		









		
		    
		
	








	
		 





		
		
			
		

	
		
		
		
		
			
		


		

		


		



	
     
        	
        
        
        

	
					
