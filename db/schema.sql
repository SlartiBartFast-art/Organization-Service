create table organizations
(
    organization_id int8         not null,
    contact_email   varchar(255) not null,
    contact_name    varchar(255) not null,
    contact_phone   varchar(255) not null,
    name            varchar(255) not null,
    primary key (organization_id)
);
