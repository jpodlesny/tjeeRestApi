#!/bin/sh

echo "************ UNDEPLOYING *******************"
~/glassfish4/bin/asadmin undeploy szpitalRestApi
echo "************ BUILDING **********************"
cd ..
mvn clean
mvn package
echo "************ DEPLOYING *********************"
~/glassfish4/bin/asadmin deploy target/szpitalRestApi.war
