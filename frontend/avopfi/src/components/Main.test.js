import { render } from '@testing-library/react';
import Main from "./Main";
import {MemoryRouter, Route,} from "react-router-dom";

test('renders main app', () => {
  const { container, getByText } = render(
    <MemoryRouter initialEntries={["/en"]}>
      <Route component={Main} />
    </MemoryRouter>
  )
  const linkElement = getByText(/About the questionnaire/i);
  expect(linkElement).toBeInTheDocument();
});
