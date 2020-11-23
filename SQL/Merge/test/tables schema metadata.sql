CREATE PROCEDURE [test].[SourceTable metadata]
AS
BEGIN
    IF @@TRANCOUNT > 0 
        BEGIN

            CREATE TABLE [test].[SourceTableExpected]( 
                  [ColumnPK]    VARCHAR(5)  NOT NULL
                , [Column1]	    VARCHAR(10) NOT NULL
                , [Column2]	    VARCHAR(10) NOT NULL
                , [Column3]	    VARCHAR(10) NOT NULL
            );

            SELECT TOP 1
                *
            INTO [test].[SourceTableActual]
            FROM dbo.SourceTable;

            EXEC tSQLt.AssertEqualsTableSchema
                N'[test].[SourceTableExpected]',
                N'[test].[SourceTableActual]';

        END 
    ELSE BEGIN
        RAISERROR('Procedure was run without tsqlt.Run. Aborting procedure', 16, 1)
    END
END
GO

CREATE PROCEDURE [test].[StaggingTable metadata]
AS
BEGIN
    IF @@TRANCOUNT > 0 
        BEGIN

            CREATE TABLE [test].[StaggingTableExpected]( 
                  [ColumnPK]    VARCHAR(5)  NOT NULL
                , [Column1]	    VARCHAR(10) NOT NULL
                , [Column2]	    VARCHAR(10) NOT NULL
                , [Column3]	    VARCHAR(10) NOT NULL
            );

            SELECT TOP 1
                *
            INTO [test].[StaggingTableActual]
            FROM dbo.StaggingTable;

            EXEC tSQLt.AssertEqualsTableSchema
                N'[test].[StaggingTableExpected]',
                N'[test].[StaggingTableActual]';

        END 
	ELSE BEGIN
        RAISERROR('Procedure was run without tsqlt.Run. Aborting procedure', 16, 1)
    END
END
GO

CREATE PROCEDURE [test].[TargetTable metadata]
AS
BEGIN
    IF @@TRANCOUNT > 0 
        BEGIN

            CREATE TABLE [test].[TargetTableExpected]( 
                  [ColumnPK]    VARCHAR(5)  NOT NULL
                , [Column1]	    VARCHAR(10) NOT NULL
                , [Column2]	    VARCHAR(10) NOT NULL
                , [Column3]	    VARCHAR(10) NOT NULL
            );

            SELECT TOP 1
                *
            INTO [test].[TargetTableActual]
            FROM dbo.TargetTable;

            EXEC tSQLt.AssertEqualsTableSchema
                N'[test].[TargetTableExpected]',
                N'[test].[TargetTableActual]';

        END 
	ELSE BEGIN
        RAISERROR('Procedure was run without tsqlt.Run. Aborting procedure', 16, 1);
    END
END
GO