import HomePage from "./Home.tsx";
import {MountLayer} from "../../cypress/support/component.tsx";

describe("Home Page", () => {
    describe("displays correct user data when a user account is loaded", () => {
        const userId = 2;
        const userName = 'Test user';

        beforeEach(() => {
            cy.intercept(`http://localhost:8080/users/${userId}`, {body: {id: userId, name: userName, email: 'test@ford.com'}});
        });

        it("I can see my name", () => {
            cy.mountWith(<HomePage />, [MountLayer.Router], {router: {type: 'memory', initialEntries: [`?uid=${userId}`]}});
            cy.get("h1").contains(userName);
        });
    });

    describe("displays correct message", () => {
        const userId = 2;

        beforeEach(() => {
            cy.intercept(`http://localhost:8080/users/${userId}`, {statusCode: 404, body: null});
        });

        it("when loading the user fails", () => {
            cy.mountWith(<HomePage />, [MountLayer.Router], {router: {type: 'memory', initialEntries: [`?uid=${userId}`]}});
            cy.get("h1").contains("Sorry, we've been unable to find your user account");
        });

        it("when no user id is provided", () => {
            cy.mountWith(<HomePage />, [MountLayer.Router]);
            cy.get("h1").contains("Sorry, we've been unable to find your user account");
        });
    });
});
