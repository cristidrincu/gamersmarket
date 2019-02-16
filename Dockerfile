FROM payara/server-full
#ENV DOMAIN_NAME domain1
#ENV INSTALL_DIR /opt
#ENV PAYARA_HOME ${INSTALL_DIR}/payara41/glassfish
#ENV EXEC {PAYARA_HOME}/bin
#ENV DEPLOY_DIR ${PAYARA_HOME}/domains/${DOMAIN_NAME}/autodeploy
COPY postgresql-42.2.1.jar /opt/payara41/glassfish/domains/domain1/lib/
COPY ./target/gamers-market.war ${DEPLOY_DIR}
EXPOSE 4848 8009 8080 8181
#ENTRYPOINT ["sh", "asadmin start-domain --verbose ${DOMAIN_NAME}"]