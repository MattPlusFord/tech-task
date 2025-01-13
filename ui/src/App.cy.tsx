import App from "./App.tsx";

describe("App", () => {
    describe("displays correct page on landing", () => {
        beforeEach(() => {
            cy.mount(<App />)
        });

        it("I can see the welcome message", () => {
            cy.get("h1").contains("Welcome Test");
        });
    });
});
