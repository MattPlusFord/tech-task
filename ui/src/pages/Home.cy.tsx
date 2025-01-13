import HomePage from "./Home.tsx";

describe("Home Page", () => {
    describe("displays correct data", () => {
        beforeEach(() => {
            cy.mount(<HomePage />)
        });

        it("I can see my name", () => {
            cy.get("h1").contains("Test");
        });
    });
});
