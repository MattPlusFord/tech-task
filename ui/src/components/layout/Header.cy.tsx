import Header from "./Header.tsx";

describe("Header", () => {
    describe("displays correctly", () => {
        beforeEach(() => {
            cy.mount(<Header />)
        });

        it("should show the company logo", () => {
            cy.get("a").contains("Ford Credit");
        });
    });
});
