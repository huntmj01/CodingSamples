CREATE PROCEDURE [test].[Setup]
AS
BEGIN

    EXEC tSQLt.FakeTable 'SourceTable', 'dbo';
    EXEC tSQLt.FakeTable 'StaggingTable', 'dbo';
    EXEC tSQLt.FakeTable 'TargetTable', 'dbo';

    INSERT INTO [test].[SourceTable] ( [ColumnPK], [Column1], [Column2], [Column3] )
    VALUES                           ( 'CLPK1',    '1111111', '2222222', '3333333' )
    ,                                ( 'CLPK2',    '4444444', '5555555', '6666666' );

END