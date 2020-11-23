CREATE PROCEDURE [test].[usp_SSIS_StaggingTarget_Merge inserts correctly]
AS
BEGIN
    IF @@TRANCOUNT > 0
        BEGIN
		    
            --Assemble
            INSERT INTO [test].[StaggingTable]  ( [ColumnPK], [Column1], [Column2], [Column3] )
            VALUES                              ( 'CLPK1',    '1111111', '2222222', '3333333' )
            ,                                   ( 'CLPK2',    '4444444', '5555555', '6666666' );

            CREATE TABLE [test].[TargetTable_Expected]( 
                  [ColumnPK]    VARCHAR(5)  NOT NULL
                , [Column1]	    VARCHAR(10) NOT NULL
                , [Column2]	    VARCHAR(10) NOT NULL
                , [Column3]	    VARCHAR(10) NOT NULL
            );
            
            INSERT INTO [test].[TargetTable_Expected] ( [ColumnPK], [Column1], [Column2], [Column3] )
            VALUES                                    ( 'CLPK1',    '1111111', '2222222', '3333333' )
            ,                                         ( 'CLPK2',    '4444444', '5555555', '6666666' );
 
            --Act
            EXEC [dbo].[usp_SSIS_StaggingTarget_Merge];

            SELECT [ColumnPK], [Column1], [Column2], [Column3]
            INTO  [test].[TargetTable_Actual] 
            FROM [dbo].[TargetTable];

            --Assert
            EXEC tSQLt.AssertEqualsTable
                '[test].[TargetTable_Expected]', 
                '[test].[TargetTable_Actual]';
            
        END
    ELSE
        BEGIN
            RAISERROR('Procedure was run without tsqlt.Run. Aborting procedure', 16, 1);
        END
END