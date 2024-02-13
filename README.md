# my-corejava

#git basic commands
git config --global user.name "<user name>"
git config --global user.email "<user email>"

#to list all the global configurations
git config --global --list

#To list all the configuration both global & user level
git config --list

#This file contains all of the configuration information.
git ~/.gitconfig

#The git repository will be initialized with the specified branch name by using this command.
git init <branch name>

#to rename the branch
git branch -M <new branch name>

#This will link with you git hub repository.
git remote add origin <git hub repository URL>

#To check the status of the branch
git status

#to add the untracked files/modified files to staging
git add <file(s) names>

#Commit the files into local repository
git commit -m "comment"

#push the local changes into the remote repository
git push origin <origin branch name>

#to get the latest code changes
git pull


#To unstage the staged file
git reset --hard <file name>

#To discard changes in working directory
git checkout -- <file name>

