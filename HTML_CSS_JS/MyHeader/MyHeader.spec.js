describe('The my header', () => {
    let myHeader;

    beforeEach(() => {
        global.customElements = {
            define: () => { }
        };
        myHeader = require('./my-header.js');
    });

    it('should exist', done => {
        expect(myHeader).not.toBeNull();
        expect(myHeader).not.toBeUndefined();
        done();
    });
});

