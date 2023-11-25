all:
	mvn test
lcn:
	mvn -Dmaven.repo.local=`pwd`/_mvnRepo clean install
#https://projects.eclipse.org/projects/ecd.sprotty
