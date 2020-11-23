import { MyHeaderHelper } from './my-header-helper';
/**
 * Description: 
 *    <my-header> is a native web component and NOT an aurelia web component. It can be used
 *    in an aurelia or non aurelia project.
 * 
 * Pre-reqs:
 *    Materlize.css must be imported onto the page you are wanting to add this component too.
 * 
 * Instructions:
 *    1. Add the following import statement into the viewmodel you want the component to be rendered in
 *        import "./my-header.js";
 *    2. Then add the component tag into the view you want the component to be rendered in
 *        <my-header 
 *            include-dropdown="true" 
 *            username="user@name"
 *            application-name="Application Name"
 *            application-home-url="https://application/index.html">
 *        </my-header>
 *    3. Finally, if you are including the dropdown, add an event listener and handler for the logout button into the viewmodel
 *        onload -> document.addEventListener('my-header-logout-clicked', handleLogoutClicked);
 *        onunload -> document.removeEventListener('my-header-logout-clicked', handleLogoutClicked);
 *        constructor -> handleLogoutClicked = e => { // your logout code here // }};
 *        
 * Attributes:
 *    include-dropdown: whether or not to include the dropdown in the nav bar which includes a link to myAdmin and Logout button
 *    username: the name of the user that will appear as the drop down text
 *    application-name: the name of the application to display in the dropdown
 *    application-home-url: the url of the home page to redirect to when the application name is clicked in the dropdown
 *    
 * Events:
 *    my-header-logout-clicked: event is fired whenever the dropdown or side nav logout button is clicked   
 **/

/* istanbul ignore next */
export class MyHeader extends HTMLElement {

    constructor() {
        super();
        this.helper = new MyHeaderHelper();
        this.innerHTML = `
            ${this.helper.getStyles()}
            <div class="my-header">
                ${this.helper.getDropdownContent(this.applicationHomeUrl, this.applicationName)}
                ${this.helper.getNav(this.username, !this.includeDropdown)}
                ${this.helper.getSideNav(this.applicationHomeUrl, this.applicationName, !this.includeDropdown)}
            </div>`;

        this.querySelector('#logout-dropdown-item').onclick = this.helper.fireLogoutEvent;
        this.querySelector('#logout-sidenav-item').onclick = this.helper.fireLogoutEvent;
    }

    connectedCallback() {
        this.initSidenav();
        this.initDropdown();
    }

    getDropdownIcon(username) {
        return `${username}<i class="material-icons right">arrow_drop_down</i>`;
    }

    initSidenav() {
        var sidenav = this.querySelector('#my-header-sidenav');
        M.Sidenav.init(sidenav, {
            edge: 'right'
        });
    }

    initDropdown() {
        var dropdown = this.querySelector('#my-header-dropdown');
        M.Dropdown.init(dropdown);
    }

    attributeChangedCallback(name, oldValue, newValue) {
        switch (name) {
            case 'include-dropdown':
                this.helper.includeDropdownChangedHandler(this.querySelector('#my-header-dropdown'),
                    this.querySelector('#application-sidenav-list-item'), this.querySelector('#logout-sidenav-list-item'),
                    newValue);
                break;
            case 'username':
                this.helper.usernameChangedHandler(this.querySelector('#my-header-dropdown'), newValue);
                break;
            case 'application-name':
                var appDropdownItem = this.querySelector('#application-dropdown-item');
                var appSidenavItem = this.querySelector('#application-sidenav-item');
                this.helper.applicationNameChangedHandler(appDropdownItem, appSidenavItem, newValue);
                break;
            case 'application-home-url':
                var appDropdownItem = this.querySelector('#application-dropdown-item');
                var appSidenavItem = this.querySelector('#application-sidenav-item');
                this.helper.applicationHomeUrlChangedHandler(appDropdownItem, appSidenavItem, newValue);
                break;
        }
    }

    static get observedAttributes() {
        return ['include-dropdown', 'username', 'application-name', 'application-home-url'];
    }

    get includeDropdown() {
        return this.getAttribute('include-dropdown') == 'true';
    }

    set includeDropdown(newValue) {
        this.setAttribute('include-dropdown', newValue);
    }

    get username() {
        return this.getAttribute('username');
    }

    set username(newValue) {
        this.setAttribute('username', newValue);
    }

    get applicationName() {
        return this.getAttribute('application-name');
    }

    set applicationName(newValue) {
        this.setAttribute('application-name', newValue);
    }

    get applicationHomeUrl() {
        return this.getAttribute('application-home-url');
    }

    set applicationHomeUrl(newValue) {
        this.setAttribute('application-home-url', newValue);
    }
}

customElements.define('my-header', MyHeader);
