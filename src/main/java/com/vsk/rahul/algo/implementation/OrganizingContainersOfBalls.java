/**
 * 
 */
package com.vsk.rahul.algo.implementation;

/**
 * Will be given a number N.
 * 
 * <p>
 * Which represents total number of containers and type of balls.
 * There is no constraint for the number of balls.
 * 
 * <p>We have to tell if we could arrange the balls like one container has one type balls only.
 * 
 * <p>
 * SWIPE METHOD : 
 * <ol>
 * <li> If we take out one ball from one container then put another ball in same container.
 * <li> If we put one ball in one container then take out one ball from same container.
 * </ol>
 * 
 * @author Rahul
 * 
 */
public class OrganizingContainersOfBalls {

	public static String canOrganize(int containers[], int ballTypes[], int N) {
		
		String canOrganize = "Possible";
		
		for(int i = 0; i < N; i++) {
			
			int j = 0;
			
			for(j = i; j < N; j++) {
				
				if(containers[i] == ballTypes[j]) {
					int temp = ballTypes[j];
					ballTypes[j] = ballTypes[i];
					ballTypes[i] = temp;
					break;
				}
			}
			
			if(j == N) {
				canOrganize = "Impossible";
				break;
			}
		}
		
		return canOrganize;
	}
}
