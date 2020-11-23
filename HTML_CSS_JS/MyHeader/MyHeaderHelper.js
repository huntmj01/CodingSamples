export class MyHeaderHelper {

    getDropdownContent(applicationHomeUrl, applicationName) {
        return `
              <ul id="dropdown1" class="dropdown-content">
                  <li><a id="application-dropdown-item" class="noHover" href="${applicationHomeUrl}">${applicationName}</a></li>
                  <li><a id="logout-dropdown-item" class="noHover" href="#" >Logout</a></li>
              </ul>
          `;
    }

    getNav(username, hideDropdown) {
        return `
              <nav>
                  <div class="nav-wrapper">
                      <a href="#" data-target="my-helper-sidenav" class="right sidenav-trigger">
                          <i class="material-icons">list</i>
                      </a>
                      <a href="#" class="brand-logo left ">
                          ${this.getLogo()}
                      </a>
                      <ul id="nav-mobile" class="right hide-on-med-and-down">
                          ${this.getNavListItems()}
                          ${this.getDropdown(username, hideDropdown)}
                      </ul>
                  </div>
              </nav>
          `;
    }

    getSideNav(applicationHomeUrl, applicationName, hide) {
        return `
              <ul class="sidenav" id="my-helper-sidenav">
                  <li ${hide ? 'hidden' : ''} id="application-sidenav-list-item"><a id="application-sidenav-item" href="${applicationHomeUrl}">${applicationName}</a></li>
                  ${this.getNavListItems()}
                  <li ${hide ? 'hidden' : ''} id="logout-sidenav-list-item"><a id="logout-sidenav-item" href="#">Logout</a></li>
              </ul>
          `;
    }

    getLogo() {
        return `Logo`;
    }

    getNavListItems() {
        return `
              <li><a href="#">Link 1</a></li>
              <li><a href="#">Link 2</a></li>
              <li><a href="#">Link 3</a></li>
              <li><a href="#">Link 4</a></li>
              <li><a href="#">Link 5</a></li>
          `;
    }

    getDropdown(username, hide) {
        return `
              <li class="dropdown">
                  <a ${hide ? 'hidden' : ''} id="my-helper-dropdown" class="dropdown-trigger" href="#!" data-target="dropdown1">
                      ${this.getDropdownIcon(username)}
                  </a>
              </li>
          `;
    }

    getDropdownIcon(username) {
        return `${username}<i class="material-icons right">arrow_drop_down</i>`;
    }

    fireLogoutEvent = () => {
        var event = document.createEvent('HTMLEvents');
        event.initEvent('my-header-logout-clicked', true, true);
        event.eventName = 'my-header-logout-clicked';
        document.dispatchEvent(event);
    }

    includeDropdownChangedHandler(dropdown, appSideNavItem, logoutSideNavItem, newValue) {
        if (dropdown != null && newValue == 'true') {
            dropdown.removeAttribute('hidden');
        } else if (dropdown != null) {
            dropdown.setAttribute('hidden', '');
        }
        if (appSideNavItem != null && newValue == 'true') {
            appSideNavItem.removeAttribute('hidden');
        } else if (appSideNavItem != null) {
            appSideNavItem.setAttribute('hidden', '');
        }
        if (logoutSideNavItem != null && newValue == 'true') {
            logoutSideNavItem.removeAttribute('hidden');
        } else if (logoutSideNavItem != null) {
            logoutSideNavItem.setAttribute('hidden', '');
        }
    }

    usernameChangedHandler(dropdown, newValue) {
        if (dropdown != null) {
            dropdown.innerHTML = this.getDropdownIcon(newValue);
        }
    }

    applicationNameChangedHandler(appDropdownItem, appSidenavItem, newValue) {
        if (appDropdownItem != null) {
            appDropdownItem.innerText = newValue;
        }
        if (appSidenavItem != null) {
            appSidenavItem.innerText = newValue;
        }
    }

    applicationHomeUrlChangedHandler(appDropdownItem, appSidenavItem, newValue) {
        if (appDropdownItem != null) {
            appDropdownItem.href = newValue;
        }
        if (appSidenavItem != null) {
            appSidenavItem.href = newValue;
        }
    }

    getStyles() {
        return `
              <style>
                  .my-header nav {
                      background-color: rgba(10,10,10,0.8);
                      font-family: Roboto, sans-serif;
                      font-size: 16px;
                      padding-left: 1rem;
                  }
  
                          .my-header nav .nav-wrapper {
                                padding-left: 15px;
                          }
  
                  .my-header nav a {
                      color: #ededed;
                  }
  
                  .my-header nav a:hover {
                      color: #fff;
                  }
  
                  .my-header nav .brand-logo {
                      font-size: 2rem !important;
                  }
  
                  .my-header a, .my-header li, .my-header nav {
                      height: 40px;
                  }
  
                  @media only screen and (min-width: 601px) {
                      .my-header nav, .my-header nav .nav-wrapper i, .my-header nav a.sidenav-trigger, .my-header nav a.sidenav-trigger i {
                          line-height: 40px;
                      }
                  }
  
                  @media only screen and (max-width: 1250px) {
                      .my-header ul {
                          width: 85%;
                          margin: auto;
                      }
                  }
  
                  @media only screen and (min-width: 1250px) {
                      .my-header ul {
                          width: 70%;
                          margin: auto;
                      }
                  }
  
                  .my-header li {
                      padding-right: 1rem;
                  }
  
                  .my-header .sidenav {
                      width: 300px;
                  }
  
                  .my-header .dropdown {
                      float: right;
                  }
  
                  .my-header .noHover {
                      background-color: unset !important;
                      color: unset !important;
                  }
              </style>
          `;
    }
}
