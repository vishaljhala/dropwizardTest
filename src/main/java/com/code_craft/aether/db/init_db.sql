create table Blocks (
  pk serial primary key,
  createdAt timestamp without time zone NOT NULL,
  updatedAt timestamp without time zone NOT NULL,
  slotId bigint UNIQUE NOT NULL,
  version text
);
