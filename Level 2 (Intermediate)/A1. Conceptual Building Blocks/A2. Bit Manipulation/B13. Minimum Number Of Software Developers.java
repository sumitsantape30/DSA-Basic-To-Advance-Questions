Minimum Number Of Software Developers

1. You are given N strings which represents N different skills related to I.T field.
2. You are working on a project and you want to hire a team of software developers for that project.
3. There are N applicants. Every applicant has mentioned his/her skills in resume.
4. You have to select the minimum number of developers such that for every required skill, there is 
     at least one person in the team who has that skill.
5. It is guaranteed that you can form a team which covers all the required skills.

Note -> Check out the question video for details.
Input Format
A number N representing number of required skills
N space separated strings 
A number M representing number of applicants
For every applicant : A number T representing number of skills of an applicant and then T number of space separated strings.
Output Format
An arraylist containing the indices of selected applicants.
Check the sample ouput and question video.

Constraints
1 <= N <= 16
1 <= length of string <= 16
1 <= M <= 60
Sample Input
3
java nodejs reactjs
3
1
java
1
nodejs
2
nodejs
reactjs
Sample Output
[0, 2]

Code:

