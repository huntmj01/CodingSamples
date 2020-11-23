import { myHeaderHelper } from './my-header-helper';

describe('The my header helper', () => {
    let helper;

    beforeEach(() => {
        helper = new myHeaderHelper();
    });

    it('should exist', () => {
        expect(helper).not.toBeNull();
        expect(helper).not.toBeUndefined();
    });

    describe('when getting dropdown content', () => {
        it('should return unordered list', () => {
            expect(helper.getDropdownContent('', '', '').includes('<ul')).toBe(true);
            expect(helper.getDropdownContent('', '', '').includes('</ul>')).toBe(true);
        });
        it('should append text to dropdown', () => {
            var applicationHomeUrl = 'http://www.app.home/';
            var applicationName = 'app name';

            var result = helper.getDropdownContent(applicationHomeUrl, applicationName);

            expect(result.includes(applicationHomeUrl)).toBe(true);
            expect(result.includes(applicationName)).toBe(true);
        });
    });

    describe('when getting the nav', () => {
        it('should return the nav', () => {
            expect(helper.getNav().includes('<nav>')).toBe(true);
            expect(helper.getNav().includes('</nav>')).toBe(true);
        });
    });

    describe('when getting the side nav', () => {
        it('should return unordered list', () => {
            expect(helper.getSideNav('', '', false).includes('<ul')).toBe(true);
            expect(helper.getSideNav('', '', false).includes('</ul>')).toBe(true);
        });
        it('should append text to side nav', () => {
            var applicationHomeUrl = 'http://www.app.home/';
            var applicationName = 'app name';

            var result = helper.getSideNav(applicationHomeUrl, applicationName, false);

            expect(result.includes(applicationHomeUrl)).toBe(true);
            expect(result.includes(applicationName)).toBe(true);
        });
        it('should return hidden list item given hide is true', () => {
            expect(helper.getSideNav('', '', true).includes('<li hidden')).toBe(true);
        });
        it('should return visbile list item given hide is false', () => {
            expect(helper.getSideNav('', '', false).includes('hidden')).toBe(false);
        });
    });

    describe('when getting the logo', () => {
        it('should return svg', () => {
            expect(helper.getLogo().includes('<svg')).toBe(true);
            expect(helper.getLogo().includes('</svg>')).toBe(true);
        });
    });

    describe('when getting nav list items', () => {
        it('should return list items', () => {
            expect(helper.getNavListItems().includes('<li>')).toBe(true);
            expect(helper.getNavListItems().includes('</li>')).toBe(true);
        });
    });

    describe('when getting dropdown', () => {
        it('should return hidden anchor given hide is true', () => {
            expect(helper.getDropdown('', true).includes('<a hidden')).toBe(true);
        });
        it('should return visivle anchor given hide is false', () => {
            expect(helper.getDropdown('', false).includes('hidden')).toBe(false);
        });
        it('should return list item', () => {
            expect(helper.getDropdown('', false).includes('<li')).toBe(true);
            expect(helper.getDropdown('', false).includes('</li>')).toBe(true);
        });
        it('should return arrow drop down icon', () => {
            expect(helper.getDropdown('', false).includes('<i class="material-icons right">arrow_drop_down</i>')).toBe(true);
        });
        it('should append username to dropdown icon', () => {
            var username = 'user@name';
            expect(helper.getDropdown(username, false).includes(username)).toBe(true);
        });
    });

    describe('when getting dropdown icon', () => {
        it('should return arrow drop down icon', () => {
            expect(helper.getDropdownIcon('').includes('<i class="material-icons right">arrow_drop_down</i>')).toBe(true);
        });
        it('should append username to dropdown icon', () => {
            var username = 'user@name';
            expect(helper.getDropdownIcon(username).includes(username)).toBe(true);
        });
    });

    describe('when getting styles', () => {
        it('should return styles', () => {
            expect(helper.getStyles().includes('<style>')).toBe(true);
            expect(helper.getStyles().includes('</style>')).toBe(true);
        });
    });

    describe('when firing logout event', () => {
        var mockDocument = document;
        var eventSpy;

        beforeEach(() => {
            eventSpy = {
                initEvent: jest.fn(() => { }),
                eventName: ''
            }
            mockDocument.createEvent = jest.fn(() => eventSpy);
            mockDocument.dispatchEvent = jest.fn(() => { });
        });

        it('should create event', () => {
            helper.fireLogoutEvent();
            expect(mockDocument.createEvent).toHaveBeenCalledWith('HTMLEvents');
        });
        it('should init event', () => {
            helper.fireLogoutEvent();
            expect(eventSpy.initEvent).toHaveBeenCalledWith('my-header-logout-clicked', true, true);
        });
        it('should set event name', () => {
            helper.fireLogoutEvent();
            expect(eventSpy.eventName).toBe('my-header-logout-clicked');
        });
        it('should dispatch event', () => {
            helper.fireLogoutEvent();
            expect(mockDocument.dispatchEvent).toHaveBeenCalledWith(eventSpy);
        });
    });

    describe('when handling include dropdown changed event', () => {
        var dropdownSpy, appSideNavItemSpy, logoutSideNavItemSpy;

        beforeEach(() => {
            dropdownSpy = {
                removeAttribute: jest.fn(() => { }),
                setAttribute: jest.fn(() => { })
            };
            appSideNavItemSpy = {
                removeAttribute: jest.fn(() => { }),
                setAttribute: jest.fn(() => { })
            };
            logoutSideNavItemSpy = {
                removeAttribute: jest.fn(() => { }),
                setAttribute: jest.fn(() => { })
            };
        });

        it('should remove dropdown hidden attribute when newValue is true', () => {
            helper.includeDropdownChangedHandler(dropdownSpy, appSideNavItemSpy, logoutSideNavItemSpy, 'true');
            expect(dropdownSpy.removeAttribute).toHaveBeenCalledWith('hidden');
            expect(dropdownSpy.setAttribute).not.toHaveBeenCalled();
        });
        it('should set dropdown hidden attribute when newValue is false', () => {
            helper.includeDropdownChangedHandler(dropdownSpy, appSideNavItemSpy, logoutSideNavItemSpy, 'false');
            expect(dropdownSpy.removeAttribute).not.toHaveBeenCalled();
            expect(dropdownSpy.setAttribute).toHaveBeenCalledWith('hidden', '');
        });
        it('should remove appSideNavItemSpy hidden attribute when newValue is true', () => {
            helper.includeDropdownChangedHandler(dropdownSpy, appSideNavItemSpy, logoutSideNavItemSpy, 'true');
            expect(appSideNavItemSpy.removeAttribute).toHaveBeenCalledWith('hidden');
            expect(appSideNavItemSpy.setAttribute).not.toHaveBeenCalled();
        });
        it('should set appSideNavItemSpy hidden attribute when newValue is false', () => {
            helper.includeDropdownChangedHandler(dropdownSpy, appSideNavItemSpy, logoutSideNavItemSpy, 'false');
            expect(appSideNavItemSpy.removeAttribute).not.toHaveBeenCalled();
            expect(appSideNavItemSpy.setAttribute).toHaveBeenCalledWith('hidden', '');
        });
        it('should remove logoutSideNavItemSpy hidden attribute when newValue is true', () => {
            helper.includeDropdownChangedHandler(dropdownSpy, appSideNavItemSpy, logoutSideNavItemSpy, 'true');
            expect(logoutSideNavItemSpy.removeAttribute).toHaveBeenCalledWith('hidden');
            expect(logoutSideNavItemSpy.setAttribute).not.toHaveBeenCalled();
        });
        it('should set logoutSideNavItemSpy hidden attribute when newValue is false', () => {
            helper.includeDropdownChangedHandler(dropdownSpy, appSideNavItemSpy, logoutSideNavItemSpy, 'false');
            expect(logoutSideNavItemSpy.removeAttribute).not.toHaveBeenCalled();
            expect(logoutSideNavItemSpy.setAttribute).toHaveBeenCalledWith('hidden', '');
        });
    });

    describe('when handling username changed event', () => {
        var dropdownSpy;

        beforeEach(() => {
            dropdownSpy = {
                innerHTML: {}
            };
        });

        it('should set dropdown inner html', () => {
            var username = 'user@name';
            helper.usernameChangedHandler(dropdownSpy, username);
            expect(dropdownSpy.innerHTML).toBe('user@name<i class=\"material-icons right\">arrow_drop_down</i>');
        });
    });

    describe('when handling application name changed event', () => {
        var appDropdownItemSpy;
        var appSidenavItemSpy;
        var applicationName = 'app name';

        beforeEach(() => {
            appDropdownItemSpy = {
                innerText: ''
            };
            appSidenavItemSpy = {
                innerText: ''
            };
        });

        it('should set dropdown item inner text', () => {
            helper.applicationNameChangedHandler(appDropdownItemSpy, appSidenavItemSpy, applicationName);
            expect(appDropdownItemSpy.innerText).toBe(applicationName);
        });
        it('should set sidenav item inner text', () => {
            helper.applicationNameChangedHandler(appDropdownItemSpy, appSidenavItemSpy, applicationName);
            expect(appSidenavItemSpy.innerText).toBe(applicationName);
        });
    });

    describe('when handling application home url changed event', () => {
        var appDropdownItemSpy;
        var appSidenavItemSpy;
        var applicationHomeUrl = 'http://www.app.home/';

        beforeEach(() => {
            appDropdownItemSpy = {
                href: ''
            };
            appSidenavItemSpy = {
                href: ''
            };
        });

        it('should set dropdown item inner text', () => {
            helper.applicationHomeUrlChangedHandler(appDropdownItemSpy, appSidenavItemSpy, applicationHomeUrl);
            expect(appDropdownItemSpy.href).toBe(applicationHomeUrl);
        });
        it('should set sidenav item inner text', () => {
            helper.applicationHomeUrlChangedHandler(appDropdownItemSpy, appSidenavItemSpy, applicationHomeUrl);
            expect(appSidenavItemSpy.href).toBe(applicationHomeUrl);
        });
    });
});