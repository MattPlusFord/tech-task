import App from "./App.tsx";

describe("App", () => {
    describe("displays correct page on landing", () => {
        beforeEach(() => {
            cy.mount(<App />);
        });

        it("I can see the welcome message", () => {
            cy.get('[data-testid="main-wrapper"]').should('be.visible');
            cy.get("a").contains("Fawd Credit");
            cy.get("p").contains("Fawd Credit Europe 2025");
        });
    });
});
