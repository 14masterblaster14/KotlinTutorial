
Git:

		CICD
	===========
	
	Build -> Test -> Delivery/ Deploy
	
	
	
	
	GIT
	============
	
	go to project folder and run
		git init
		git status
		
		git add app/ 									<For specific folder>
		git add .										<For all folders and files in the directory>
		git commit -m "type ur message here"
		
		git commit -a -m "type ur message here"			<single command to add and commit code>
		git commit -am "type ur message here"			<single command to add and commit code>
		
		git log   				<see complete log>
	
	-------
		git branch										<Lists all branches>
		git checkout -b dev								<Create new branch>
		
	------
		git merge feature-1								<It will merge feature1 to the current branch (
														always run this on the branch where u want to merge other branch e.g. run on dev to merge feature-1 branch into dev)>
		
		Now, feture-1 is merged to dev, so u can delete feature-1 branch
		
		git branch -d feature-1							<delete feature-1 branch>
		
	---
		How to add remote 
		
		git remote add origin <url copied from github repo>
		
		git push origin master  						<master will be pushed to origin>
		
		git push -u origin master  						<master will be pushed to origin with setting remote offstream, so next time u can just use git push and it will automatically take master branch>
		git push										
