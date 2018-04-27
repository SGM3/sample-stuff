create index IX_C8766E2E on Sample_SampleThing (someString[$COLUMN_LENGTH:75$]);
create index IX_7B144509 on Sample_SampleThing (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_F5CC79CB on Sample_SampleThing (uuid_[$COLUMN_LENGTH:75$], groupId);