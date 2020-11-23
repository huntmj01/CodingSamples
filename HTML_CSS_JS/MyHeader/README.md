Dev Notes
- Within the NPM package my-header you'll notice a my-header-helper.js file that the my-header.js file imports. The reason this exists is because I was unable to get the jest framework to run a native web component so I moved the logic out into the helper file and wrote tests for the helper. 
- If you are using jest as your test framework, you may need to add the following line to the test file using the web component. Jest does not include node_module files by default.
  - jest.mock('./my-header.js', () => '');

Additional Resources
- https://alligator.io/web-components/attributes-properties/ 
- https://css-tricks.com/an-introduction-to-web-components/ 
- https://youtu.be/PCWaFLy3VUo