CREATE TABLE [dbo].[SourceTable]
( 
	  [ColumnPK]    VARCHAR(5)  NOT NULL
	, [Column1]	    VARCHAR(10) NOT NULL
	, [Column2]	    VARCHAR(10) NOT NULL
	, [Column3]	    VARCHAR(10) NOT NULL
	, CONSTRAINT [PK_SourceTable_ColumnPK] PRIMARY KEY CLUSTERED (
		[ColumnPK] ASC
	) ON [PRIMARY]
);
GO

CREATE TABLE [dbo].[StaggingTable]
( 
      [ColumnPK]    VARCHAR(5)  NOT NULL
    , [Column1]	    VARCHAR(10) NOT NULL
    , [Column2]	    VARCHAR(10) NOT NULL
    , [Column3]	    VARCHAR(10) NOT NULL
    , CONSTRAINT [PK_StaggingTable_ColumnPK] PRIMARY KEY CLUSTERED (
        [ColumnPK] ASC
    ) ON [PRIMARY]
);
GO

CREATE TABLE [dbo].[TargetTable]
( 
    [ColumnPK]      VARCHAR(5)  NOT NULL
    , [Column1]	    VARCHAR(10) NOT NULL
    , [Column2]	    VARCHAR(10) NOT NULL
    , [Column3]	    VARCHAR(10) NOT NULL
    , CONSTRAINT [PK_TargetTable_ColumnPK] PRIMARY KEY CLUSTERED (
    [ColumnPK] ASC
    ) ON [PRIMARY]
);
GO