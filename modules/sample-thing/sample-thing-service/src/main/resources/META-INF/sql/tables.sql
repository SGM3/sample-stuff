create table Sample_SampleThing (
	uuid_ VARCHAR(75) null,
	sampleId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	someString VARCHAR(75) null,
	someBoolean BOOLEAN,
	someInt INTEGER,
	someDate DATE null
);