create table TWDS(sn varchar(40), twid varchar(40), wcoid varchar(40), chName varchar(80),enName varchar(80),chDef varchar(400),enDef varchar(400),proplength varchar(40), DSTYPE varchar(30), PRIMARY KEY (twid))
create table TWCLS(classid varchar(20),objectClass varchar(80), classname varchar(40), chDef varchar(800), enDef varchar(800), PRIMARY KEY (objectClass))
create table TWDENS(den varchar(200),twid varchar(40), chName varchar(80), objectClass varchar(80),propertyTerm varchar(80),RepTerm varchar(80),NamedComplexType varchar(100),XMLTagName varchar(40),DENSTYPE varchar(30),PRIMARY KEY (den))
CREATE UNIQUE INDEX classid ON TWCLS (classid)
ALTER TABLE TWDENS ADD FOREIGN KEY (twid) REFERENCES TWDS(twid)
ALTER TABLE TWDENS ADD FOREIGN KEY (objectClass) REFERENCES TWCLS(objectClass)




insert into TWDENS (DEN, TWID,CHNAME,OBJECTCLASS,PROPERTYTERM,REPTERM,NAMEDCOMPLEXTYPE,XMLTAGNAME) values ( 	
'UCR. Trader Assigned Reference. Identifier','009','','UCR','Trader Assigned Reference','Identifier','UCRTraderAssignedReferenceIDType','TraderAssignedReferenceID')





SELECT a.NAMEDCOMPLEXTYPE, b.CHNAME  FROM TWDENS a, TWDS b  WHERE a.DEN = 'UCR. Trader Assigned Reference. Identifier' AND  a.TWID=b.TWID


insert into TWDS (TWID, WCOID,CHNAME,ENNAME,CHDEF,ENDEF,PROPLENGTH) values ( 
'009','009','','Trader reference','','Reference assigned by a trader to a declaration.','an..35')

ALTER TABLE twdens ADD COLUMN endef varchar(400);

insert into TWDS (TWID, ENNAME,ENDEF, dstype) select twcls.classid, twcls.classname, twcls.endef,'CLASS' from twcls